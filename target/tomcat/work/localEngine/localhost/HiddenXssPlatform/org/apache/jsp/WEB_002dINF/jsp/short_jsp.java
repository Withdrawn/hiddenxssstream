package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class short_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>Hidden Xss Platform</title>\r\n");
      out.write("\t<script src=\"js/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("\t <script src=\"js/check.js\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/short.css\">\r\n");
      out.write("\t<script>\r\n");
      out.write("        function checkShortForm(oform)\r\n");
      out.write("        {\r\n");
      out.write("            var divid=\"#\"+oform.parentNode.id;\r\n");
      out.write("            var shortvalue=$(\"#inputshort\").val();\r\n");
      out.write("            if(shortvalue!=\"\"&&(shortvalue.length<6||shortvalue.length>7))\r\n");
      out.write("            {\r\n");
      out.write("            \talert('自定义的网址不正确');\r\n");
      out.write("            \treturn false;\r\n");
      out.write("            }\r\n");
      out.write("            if(IsURL($(divid+\" #inputurl input\").val()))\r\n");
      out.write("                return true;\r\n");
      out.write("            else\r\n");
      out.write("            {\r\n");
      out.write("                alert('网址不合法');\r\n");
      out.write("                return false;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav.jsp", out, false);
      out.write("\r\n");
      out.write("     <div id=\"wrap\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"content\">\r\n");
      out.write("            <h1 style=\"font-family:Pmingliu;\">xss 短网址<span  class=\"font\">当前收藏</span><span class=\"num\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.shortcount }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span><span class=\"font\">个</span></h1>\r\n");
      out.write("    \t<div class=\"tabs\" >\r\n");
      out.write("            <ul id=\"tabs\">\r\n");
      out.write("                <li class=\"tab-nav-action\">生成短网址</li>\r\n");
      out.write("                <li class=\"tab-nav\">其它短网址</li>\r\n");
      out.write("                <li class=\"tab-nav\">网址还原</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"tabs-body\" class=\"tabs-body\">\r\n");
      out.write("            <div style=\"display:block\" id=\"div1\">\r\n");
      out.write("                <form action=\"short\" method=\"post\" onsubmit=\"return checkShortForm(this)\">\r\n");
      out.write("                    输入长网址:&nbsp;&nbsp;<br/>\r\n");
      out.write("                        <div id=\"inputurl\">\r\n");
      out.write("                            <input type=\"text\" name=\"long_url\" maxlength=\"100\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    自定义:&nbsp;http://xx.cn/<input id=\"inputshort\" type=\"text\" name=\"defineurl\" size=\"10\"  maxlength=\"6\">字母数字(6位)<br/><br/>\r\n");
      out.write("                    <div style=\"width:400px; marign:0 auto; height:40px;\">\r\n");
      out.write("                        <input type=\"submit\" value=\"生成\" name=\"send\" style=\"float:right;\">    \r\n");
      out.write("                    </div>\r\n");
      out.write("                      ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"display:none\" id=\"div2\">\r\n");
      out.write("                  其他短网址\r\n");
      out.write("                    <form action=\"\">\r\n");
      out.write("                        <input type=\"radio\" value=\"baidu.com\" name=\"x\" checked=checked> 百度\r\n");
      out.write("                        <input type=\"radio\" value=\"baidu.com\" name=\"x\"> 新浪\r\n");
      out.write("                        <input type=\"radio\" value=\"baidu.com\" name=\"x\"> 腾讯\r\n");
      out.write("                        <input type=\"radio\" value=\"baidu.com\" name=\"x\"> qoiob\r\n");
      out.write("                        <br/>\r\n");
      out.write("                        输入长网址:&nbsp;&nbsp;\r\n");
      out.write("                        <div id=\"inputurl\">\r\n");
      out.write("                            <input type=\"text\" name=\"long_url\" maxlength=\"100\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <br/>\r\n");
      out.write("                        <div style=\"width:400px; marign:0 auto; height:40px;\">\r\n");
      out.write("                           <input type=\"submit\" value=\"还原网址\" name=\"send\" style=\"float:right;\">    \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>   \r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"display:none\" id=\"div3\">\r\n");
      out.write("                   <form action=\"javascript:void(0)\">\r\n");
      out.write("                        请输入短网址:<br/>\r\n");
      out.write("                        <div id=\"inputurl\">\r\n");
      out.write("                            <input type=\"text\" name=\"short_url\"  id=\"short_url\" maxlength=\"100\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <br/>\r\n");
      out.write("                        <div style=\"width:400px; marign:0 auto; height:40px;\">\r\n");
      out.write("                           <input type=\"submit\" value=\"还原网址\" name=\"send\" id=\"recovery\"style=\"float:right;\">    \r\n");
      out.write("                        </div>\r\n");
      out.write("                      \t<span id=\"shortmsg\">\r\n");
      out.write("                      \t\t\r\n");
      out.write("                      \t</span>\r\n");
      out.write("                    </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("            $(\"#tabs li\").bind(\"click\", function () {\r\n");
      out.write("                var index = $(this).index();\r\n");
      out.write("                var divs = $(\"#tabs-body > div\");\r\n");
      out.write("                $(this).parent().children(\"li\").attr(\"class\", \"tab-nav\");//将所有选项置为未选中\r\n");
      out.write("                $(this).attr(\"class\", \"tab-nav-action\"); //设置当前选中项为选中样式\r\n");
      out.write("                divs.hide();//隐藏所有选中项内容\r\n");
      out.write("                divs.eq(index).show(); //显示选中项对应内容\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("        $(\"#recovery\").click(function(){\r\n");
      out.write("        \tif(IsShort($(\"#short_url\").val()))\r\n");
      out.write("        \t{\r\n");
      out.write("        \t\t\t$.ajax({\r\n");
      out.write("\t\t\t        type: \"GET\",\r\n");
      out.write("\t\t\t        url: \"recovery?short_url=\"+$(\"#short_url\").val(), \r\n");
      out.write("\t\t\t        contentType: \"application/json; charset=utf-8\",\r\n");
      out.write("\t\t\t        data:\"\",\r\n");
      out.write("\t\t\t        dataType: \"html\",\r\n");
      out.write("\t\t\t        success: function (result,textStatus) {\r\n");
      out.write("\t\t\t       \t\tif(result!='null')\r\n");
      out.write("\t\t\t      \t\t   $(\"#shortmsg\").text(result);\r\n");
      out.write("\t\t\t      \t\telse\r\n");
      out.write("\t\t\t      \t\t$(\"#shortmsg\").text(\"无法还原该短网址\");\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t      });\r\n");
      out.write("        \t}else\r\n");
      out.write("        \t{\r\n");
      out.write("        \t\talert('网址不合法');\r\n");
      out.write("        \t}\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/short.jsp(56,22) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${convented!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                      <span>短网址：\r\n");
        out.write("                        <script >\r\n");
        out.write("\t                        host = window.location.host;\r\n");
        out.write("\t                        document.write(host);\r\n");
        out.write("\t                        </script>/HiddenXssPlatform?");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${convented}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("<br/><a href=\"javascript:void(0)\" >复制</a>\r\n");
        out.write("                        </span>\r\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
