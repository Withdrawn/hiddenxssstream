package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class projectdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>项目</title>\r\n");
      out.write("\t <base href=\" ");
      out.print(basePath);
      out.write("\"> \r\n");
      out.write("\t<style>\r\n");
      out.write("\ttable,body,caption,div,td,tr,ul,li{margin:0;padding:0;}\r\n");
      out.write("\tbody{font-size:14px; }\r\n");
      out.write("\ta{color:#0066cc; font-size: 16px; text-decoration: none;}\r\n");
      out.write("\r\n");
      out.write("\t#wrapper{width:100%; height:auto;}\r\n");
      out.write("\t#detailheader {width:100%; height:auto; }\r\n");
      out.write("\t#detailheader  table{width:100%; height:auto; background:#c8e1fa;}\r\n");
      out.write("\t#detailheader caption{width:100%; height:80px; background:#224b73;  text-align:left;padding: 4px 7px 4px 5px;}\r\n");
      out.write("\t#detailheader caption a{float:right; font-size:12px;text-decoration:underline;  margin-left:3px; margin-right:3px;  text-align:center;width:70px; height:20px ; line-height:20px; display:block; cursor: pointer;color: #c8e1fa;}\r\n");
      out.write("\t#detailheader thead{display: table-header-group;}\r\n");
      out.write("\t#detailheader thead th{text-align:left;}\r\n");
      out.write("\t#detailheader tbody{color: #224b73;}\r\n");
      out.write("\t#detailheader tbody a{font-size:12px;}\r\n");
      out.write("\t#detailheader ul{margin:0; width:220px; overflow:scroll-x; word-break:break-all}\r\n");
      out.write("\t.ohidden ul { height:18px; overflow:hidden }\r\n");
      out.write("\ta.oall,a.un { text-decoration:none }\r\n");
      out.write("\ttd { vertical-align:top }\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<script src=\"js/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\"a.oall\").click(function(){\r\n");
      out.write("\t\tif($(this).attr(\"class\")==\"oall\"){\r\n");
      out.write("\t\t\t$(\"table tbody tr\").attr(\"class\",\"\");\r\n");
      out.write("\t\t\t$(\"a.un\").html(\"-折叠\");\r\n");
      out.write("\t\t\t$(this).attr(\"class\",\"uall\");\r\n");
      out.write("\t\t\t$(this).html(\"-全部\");\t\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$(\"table tbody tr\").attr(\"class\",\"ohidden\");\r\n");
      out.write("\t\t\t$(\"a.un\").html(\"+展开\");\r\n");
      out.write("\t\t\t$(this).attr(\"class\",\"oall\");\r\n");
      out.write("\t\t\t$(this).html(\"+全部\");\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"a.un\").click(function(){\r\n");
      out.write("\t\tif($(this).parent().parent().attr(\"class\")==\"ohidden\"){\r\n");
      out.write("\t\t\t$(this).parent().parent().attr(\"class\",\"\");\r\n");
      out.write("\t\t\t$(this).html(\"-折叠\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$(this).parent().parent().attr(\"class\",\"ohidden\");\r\n");
      out.write("\t\t\t$(this).html(\"+展开\");\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("function Delete(id,obj,token){\r\n");
      out.write("\tif(confirm(\"确定删除吗?\")){\r\n");
      out.write("\t\t$.post('/index.php?do=project&act=delcontent&r='+Math.random(),{'id':id,'token':token},function(re){\r\n");
      out.write("\t\t\tif(re==1){\r\n");
      out.write("\t\t\t\t$(obj).parent().parent().remove();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function MutiDelete(){\r\n");
      out.write("\tif(confirm(\"确定删除选中的内容吗?\")){\r\n");
      out.write("\t\tvar ids=[];\r\n");
      out.write("\t\t$.each($(\".checon\"),function(k,v){\r\n");
      out.write("\t\t\tif($(v).is(\":checked\")) ids.push($(v).val());\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$.post('/index.php?do=project&act=delcontents&r='+Math.random(),{'ids':ids.join(\"|\"),'token':$(\"#token\").val()},function(re){\r\n");
      out.write("\t\t\tif(re==1){\r\n");
      out.write("\t\t\t\t$(\".checon\").parent().parent().remove();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function CheckAll(obj){\r\n");
      out.write("\tif($(obj).is(\":checked\")){\r\n");
      out.write("\t\t$(\".checon\").attr(\"checked\",\"checked\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$(\".checon\").removeAttr(\"checked\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\t<div id=\"detailheader\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<caption align=\"top\">\r\n");
      out.write("\t\t\t\t<h3>项目名称:<a>配置</a><a href=\"project/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.p_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/viewcode\">查看代码</a></h3>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tDomain:<select><option value=\"\">全部</option></select>\t\t \t\t\t时间<select><option value=\"\">1小时前</option></select>\t\r\n");
      out.write("\t\t\t</caption>\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t<th width=\"20\"><input type=\"checkbox\" id=\"checkall\" onclick=\"CheckAll(this)\"></th>\r\n");
      out.write("\t\t\t\t\t<th width=\"40\"><a style=\"font-size:14px;\" class=\"oall\" href=\"javascript:void(0)\">+全部</a></th>\r\n");
      out.write("\t\t\t\t\t<th width=\"120\">时间</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"220\">接收的内容</th>\r\n");
      out.write("\t\t\t\t\t<th  width=\"220\">Request Headers</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"30\">操作</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/projectdetail.jsp(108,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("content");
    // /WEB-INF/jsp/projectdetail.jsp(108,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/projectdetail.jsp(108,3) '${contents}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${contents}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<tr class=\"ohidden\">\r\n");
          out.write("\t\t\t\t\t<td width=\"20\"><input type=\"checkbox\" class=\"checon\" value=\"\"></td>\r\n");
          out.write("\t\t\t\t\t<td  width=\"40\"><a href=\"javascript:void(0)\"  class=\"un\">+展开</a></td>\r\n");
          out.write("\t\t\t\t\t<td width=\"120\">2014-10-30 00:09:47</td>\r\n");
          out.write("\t\t\t\t\t<td width=\"220\">\r\n");
          out.write("\t\t\t\t\t\t<ul>\r\n");
          out.write("\t\t\t\t\t\t\t<li>location:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${content.location}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</li>\r\n");
          out.write("\t\t\t\t\t\t\t<li>toplocation:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${content.toplocation}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</li>\r\n");
          out.write("\t\t\t\t\t\t\t<li>cookie:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${content.cookie}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</li>\r\n");
          out.write("\t\t\t\t\t\t\t<li>opener:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${content.opener}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</li>\r\n");
          out.write("\t\t\t\t\t\t</ul>\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t<td width=\"220\">\r\n");
          out.write("\t\t\t\t\t\t<ul>\r\n");
          out.write("\t\t\t\t\t\t\t<li>REFERER:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${content.referer}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</li>\r\n");
          out.write("\t\t\t\t\t\t\t<li>USER_AGENT:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${content.useragent}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</li>\r\n");
          out.write("\t\t\t\t\t\t\t<li>REMOTE_ADDR:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${content.remote_addr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</li>\r\n");
          out.write("\t\t\t\t\t\t</ul>\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t<td width=\"30\"><a href=\"content/delete\" onclick=\"return confirm('确定删除吗?');\">删除</a></td>\r\n");
          out.write("\t\t\t\t\t\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t");
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
