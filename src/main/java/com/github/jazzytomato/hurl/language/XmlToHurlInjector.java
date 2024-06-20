package com.github.jazzytomato.hurl.language;

import com.github.jazzytomato.hurl.language.psi.HurlBody;
import com.github.jazzytomato.hurl.language.psi.HurlTypes;
import com.github.jazzytomato.hurl.language.psi.HurlXml;
import com.intellij.json.JsonLanguage;
import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.lang.xml.XMLLanguage;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.NotNull;

import java.util.List;

final class XmlToHurlInjector implements MultiHostInjector {

  @Override
  public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar,
                                   @NotNull PsiElement context) {
    if ((context.getNode().getTreeParent().getElementType() == HurlTypes.BODY || context.getNode().getTreeParent().getElementType() == HurlTypes.MULTILINE_XML_STRING) &&
            context.getNode().getElementType() == HurlTypes.XML) {
      registrar
        .startInjecting(XMLLanguage.INSTANCE)
        .addPlace(null, null,
                  (PsiLanguageInjectionHost)context,
                TextRange.allOf(context.getNode().getText()))
        .doneInjecting();
    }
  }

  @Override
  public @NotNull List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
    return List.of(HurlXml.class);
  }
}