/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-26 06:28:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class boardWriteForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1688362096974L));
    _jspx_dependants.put("jar:file:/C:/workspace/5_Server/community/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>게시글 등록</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/boardWriteForm-style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/main-style.css\">\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/c8b00b753f.js\"\r\n");
      out.write("   crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form action=\"write\" enctype=\"multipart/form-data\" method=\"POST\" class=\"board-write\"\r\n");
      out.write("            onsubmit=\"return writeValidate()\">\r\n");
      out.write("\r\n");
      out.write("            <!-- 제목 -->\r\n");
      out.write("            <h1 class=\"board-title\">\r\n");
      out.write("                <input type=\"text\" name=\"boardTitle\" placeholder=\"제목을 입력해주세요.\">\r\n");
      out.write("            </h1>\r\n");
      out.write("\r\n");
      out.write("            <!-- 썸네일 -->\r\n");
      out.write("            <h5>썸네일</h5>\r\n");
      out.write("            <div class=\"img-box\">\r\n");
      out.write("                <div class=\"boardImg thumbnail\">\r\n");
      out.write("                    <label for=\"img0\">\r\n");
      out.write("                        <img class=\"preview\">\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <input type=\"file\" class=\"inputImage\" id=\"img0\" name=\"0\" accept=\"image/*\">\r\n");
      out.write("                    <span class=\"delete-image\">&times;</span>\r\n");
      out.write("                    <!-- &times; : x 모양의 문자 -->\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- 업로드 이미지 -->\r\n");
      out.write("            <h5>업로드 이미지</h5>\r\n");
      out.write("            <div class=\"img-box\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"boardImg\">\r\n");
      out.write("                    <label for=\"img1\">\r\n");
      out.write("                        <img class=\"preview\">\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <input type=\"file\" class=\"inputImage\" id=\"img1\" name=\"1\" accept=\"image/*\">\r\n");
      out.write("                    <span class=\"delete-image\">&times;</span>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"boardImg\">\r\n");
      out.write("                    <label for=\"img2\">\r\n");
      out.write("                        <img class=\"preview\">\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <input type=\"file\" class=\"inputImage\" id=\"img2\" name=\"2\" accept=\"image/*\">\r\n");
      out.write("                    <span class=\"delete-image\">&times;</span>\r\n");
      out.write("                </div>\r\n");
      out.write("    \r\n");
      out.write("                <div class=\"boardImg\">\r\n");
      out.write("                    <label for=\"img3\">\r\n");
      out.write("                        <img class=\"preview\">\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <input type=\"file\" class=\"inputImage\" id=\"img3\" name=\"3\" accept=\"image/*\">\r\n");
      out.write("                    <span class=\"delete-image\">&times;</span>\r\n");
      out.write("                </div>\r\n");
      out.write("    \r\n");
      out.write("                <div class=\"boardImg\">\r\n");
      out.write("                    <label for=\"img4\">\r\n");
      out.write("                        <img class=\"preview\">\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <input type=\"file\" class=\"inputImage\" id=\"img4\" name=\"4\" accept=\"image/*\">\r\n");
      out.write("                    <span class=\"delete-image\">&times;</span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- 내용 -->\r\n");
      out.write("            <div class=\"board-content\">\r\n");
      out.write("                <textarea name=\"boardContent\"></textarea>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- 버튼 영역 -->\r\n");
      out.write("            <div class=\"board-btn-area\">\r\n");
      out.write("                <button type=\"submit\" id=\"writeBtn\">등록</button>\r\n");
      out.write("                <button type=\"button\" id=\"gotoListBtn\">목록으로</button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- 숨겨진 값(hidden) -->\r\n");
      out.write("            <!-- 동작 구분 -->\r\n");
      out.write("            <input type=\"hidden\" name=\"mode\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.mode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("            <!-- 게시판 구분 -->\r\n");
      out.write("            <input type=\"hidden\" name=\"type\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/board/board.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/board/boardWriteForm.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
