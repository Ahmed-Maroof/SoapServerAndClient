<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<body>

    <div class="container">
         userContent
    <div>"${name}" , "${balance}"</div>
    <div>--------------------------------------</div>
    <table id="bills" class="table table-striped">
            <thead>
                <tr>
                    <th style="width: 150px;">name</th>
                    <th style="width: 150px;">status</th>
                    <th style="width: 120px">value</th>
                    <th style="width: 120px">value</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${bills}" var="bill">
                    <tr>
                        <td style="width: 150px;"><c:out value="${bill.name}"/></td>
                        <td style="width: 150px;"><c:out value="${bill.status}"/></td>
                        <td style="width: 150px;"><c:out value="${bill.value}"/></td>
                      <td>
                       <form class="form-pay" action="/paybill" method="POST">
                       <button class="btn btn-large btn-primary" type="submit" >pay-bill</button>
                       </form>
                       </td>
                  </c:forEach>

                </tr>
            </tbody>
        </table>
    </div>
  </body>
</html>