<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<HEAD>
    <!-- JQuerry library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


    <script type="text/javascript">
        $(document).on("click", "#make_move", function () {
            $.get("http://localhost:9090/make_move", function (responseJson) {
                var $tbody = $("<tbody>").appendTo($("#for_tails_list"));
                $.each(responseJson, function (index, tail) {
                    let tl = document.getElementById(tail.id.toString());
                    tl.innerHTML = tail.figure.fig.toString();
                });
            });
        })
    </script>

</HEAD>
<title>Spring MVC, Hibernate and criteria Example</title>
<body>
<h2>Spring MVC, Hibernate and criteria Example</h2>
<h3>Find course by Student name</h3>

<button id="show_all_courses" ,>Show all courses</button>
<br/> <br/>

<button id="show_expensive_courses" ,>Show the most expensive courses</button>
<br/> <br/>

<form ID="find_course_by_student" method="GET" action="http://localhost:9090/criteriaDemo_war_exploded/courses/find/">
    Student name:
    <input name="name" type="text"/><br/> <br/>
    <input type="submit" name="Find by name" value="Submit"/>
</form>

<h3>List of courses</h3>
<table id="for_course_list" cellpadding="5" cellspacing="5">
    <thead class="title">
    <tr class="title">
        <th class="title">id</th>
        <th class="title">Course</th>
        <th class="title">Cost</th>
    </tr>
    </thead>

</table>
</body>
</html>
