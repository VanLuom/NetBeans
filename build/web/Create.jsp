<%-- 
    Document   : Create
    Created on : Apr 14, 2023, 8:12:59 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card-body">
            <form action="CreateServlet" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">Name</label>
                    <input type="text" name="name" class="form-control"  placeholder="Enter name">

                </div>

                <div class="form-group">
                    <label for="exampleInputPassword1">Description</label>
                    <input type="text" name="description" class="form-control" placeholder="Description">
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword1">Price</label>
                    <input type="text" name="price" class="form-control"  placeholder="Price">
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword1">Quantity</label>
                    <input type="text" name="quantity" class="form-control" placeholder="Quantity">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">View</label>
                    <input type="text" name="View" class="form-control" placeholder="Enter view">

                </div>

                <div class="form-group">

                    <input type="text" name="category_id">

                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
