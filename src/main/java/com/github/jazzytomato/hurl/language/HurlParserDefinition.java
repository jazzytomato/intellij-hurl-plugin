package com.github.jazzytomato.hurl.language;

import com.github.jazzytomato.hurl.language.parser.HurlParser;
import com.github.jazzytomato.hurl.language.psi.HurlFile;
import com.github.jazzytomato.hurl.language.psi.HurlTokenSets;
import com.github.jazzytomato.hurl.language.psi.HurlTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

final class HurlParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(HurlLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new HurlLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return HurlTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return TokenSet.WHITE_SPACE;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new HurlParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new HurlFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return HurlTypes.Factory.createElement(node);
    }

}
