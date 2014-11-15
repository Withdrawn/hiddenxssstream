package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/spring-form.tld");
    _jspx_dependants.add("/WEB-INF/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("     <base href=\" ");
      out.print(basePath);
      out.write("\"> \r\n");
      out.write("    <title>HiddenXssStream</title>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"xss,platform,跨站\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is a xss platform for registed users\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/swfobject.js\">\r\n");
      out.write("\t\tif(window!=window.top){ //防钓鱼代码\r\n");
      out.write("\t\twindow.top.location.href=window.location.href;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/homepage.css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t function iFrameHeight(ifm) {\r\n");
      out.write("        \tvar subWeb = document.frames ? document.frames[\"contentfrm\"].document :ifm.contentDocument;\r\n");
      out.write("            if(ifm != null && subWeb != null) {\r\n");
      out.write("            \tifm.height = subWeb.body.scrollHeight+100;\r\n");
      out.write("            }\r\n");
      out.write("   \t\t}  \r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("  ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav.jsp", out, false);
      out.write("\r\n");
      out.write("<div id=\"header\"></div>\r\n");
      out.write("\t <div id=\"bodylayout\">\r\n");
      out.write("\t \t\t<div id=\"bodyleft\">\r\n");
      out.write("\t \t\t\t<div id=\"userhead\">\r\n");
      out.write("\t \t\t\t\t<img src=\"images/100.png\" alt=\"\">\r\n");
      out.write("\t \t\t\t</div>\r\n");
      out.write("\t \t\t\t<div class=\"usernav\">\r\n");
      out.write("\t \t\t\t\t<ul>\r\n");
      out.write("\t\t \t\t\t\t<li><a target=\"contentfrm\" href=\"project\">我的项目</a></li>\r\n");
      out.write("\t\t \t\t\t\t<div class=\"h2_cat\" onmouseover=\"this.className='h2_cat active_cat'\" onmouseout=\"this.className='h2_cat'\">\r\n");
      out.write("\t\t \t\t\t\t<li ><a target=\"contentfrm\" href=\"module\">\r\n");
      out.write("\t\t \t\t\t\t\t我的模块</a>\r\n");
      out.write("\t\t \t\t\t\t\t<div class=\"h3_cat\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"shadow_border\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t \t\t\t\t</li></div>\r\n");
      out.write("\t\t \t\t\t\t<li><a target=\"contentfrm\" href=\"pubmodule\">我的模块--公共模块</a></li>\r\n");
      out.write("\t\t \t\t\t\t<li><a target=\"contentfrm\" href=\"message\">我的消息</a></li>\r\n");
      out.write("\t\t \t\t\t\t<li><a target=\"contentfrm\" href=\"memory\">我的回忆</a></li>\r\n");
      out.write("\t\t \t\t\t\t<li><a target=\"contentfrm\" href=\"arm\">我的利器</a></li>\r\n");
      out.write("\t\t \t\t\t\t<li><a target=\"contentfrm\" href=\"info\">个人信息</a></li>\r\n");
      out.write("\t \t\t\t\t</ul>\r\n");
      out.write("\t \t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t \t\t</div>\r\n");
      out.write("\t \t\t<div id=\"bodyright\" >\r\n");
      out.write("\t \t\t\t<iframe src=\"\" onload=\"iFrameHeight(this)\" frameborder=\"0\" width=\"100%\" height=\"100%\" scrolling=\"no\" name=\"contentfrm\" id=\"contentfrm\">\r\n");
      out.write("\t \t\t\t</iframe>\r\n");
      out.write("\t \t\t</div>\r\n");
      out.write("\t \t\t<div style=\"clear:both;\"></div>\r\n");
      out.write("\t </div>\r\n");
      out.write("\t <div id=\"bottomlay\">\r\n");
      out.write("\t \t\t<iframe src=\"bottom.html\" width='100%' height='60px' scrolling='no' frameborder=\"0\"></iframe>\r\n");
      out.write("\t </div>\r\n");
      out.write("  </body>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("   \t//\tvar params = {};   \r\n");
      out.write("   \t\t// params.allowscriptaccess = \"sameDomain\";\r\n");
      out.write("\t\t// swfobject.embedSWF(\"images/platformcookie.swf\", \"loginflash\", \"200\", \"120\", \"9.0.0\", \"expressInstall.swf\",params);\r\n");
      out.write("\t\t// var uname={};\r\n");
      out.write("\t\t// uname.value=document.cookie.split(\";\")[2].split(\"=\")[1];\r\n");
      out.write("\t\t// var upass={};\r\n");
      out.write("\t\t// upass.value=document.cookie.split(\";\")[3].split(\"=\")[1];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t //setTimeout(function(){window[\"loginflash\"].saveCookies(\"xss_uname\",uname);window[\"loginflash\"].saveCookies(\"xss_upass\",upass)},3000);\r\n");
      out.write("\r\n");
      out.write("  </script>\r\n");
      out.write("</html>\r\n");
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
    // /WEB-INF/jsp/homepage.jsp(38,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.msg!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("  \t<script>alert('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.msg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("');</script>\r\n");
        out.write("  ");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/homepage.jsp(57,11) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("module");
    // /WEB-INF/jsp/homepage.jsp(57,11) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/homepage.jsp(57,11) '${modules }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${modules }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<li><a target=\"contentfrm\"  href=\"module/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${module.m_id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${module.m_title }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
