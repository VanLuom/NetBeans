<%-- 
    Document   : home
    Created on : Apr 7, 2023, 8:24:57 AM
    Author     : ACER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Zay Shop</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="./assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="./assets/img/favicon.ico">

        <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="./assets/css/templatemo.css">
        <link rel="stylesheet" href="./assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="./assets/css/fontawesome.min.css">

    </head>

    <body>
        <%@include file="./inc/header.jsp" %>
        <!-- banner -->
        <%@include file="./inc/banner.jsp" %>

        <!-- Start Categories of The Month -->
        <section class="container py-5">
            <div class="row text-center pt-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Categories of The Month</h1>
                    <p>
                        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
                        deserunt mollit anim id est laborum.
                    </p>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${categoryList}" var="category">
                    <div class="col-12 col-md-4 p-5 mt-3">
                        <a href="CategoryServlet?category_id=${category.id}"><img src="${category.image}" class="rounded-circle img-fluid border"></a>
                        <h5 class="text-center mt-3 mb-3">${category.name}</h5>
                        <p class="text-center"><a class="btn btn-success">Go Shop</a></p>
                    </div>
                </c:forEach>
            </div>
        </section>
        <!-- End Categories of The Month -->


        <!-- Start Featured Product -->
        <section class="bg-light">
            <div class="container py-5">
                <div class="row text-center py-3">
                    <div class="col-lg-6 m-auto">
                        <h1 class="h1">Featured Product</h1>
                        <p>
                            Reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                            Excepteur sint occaecat cupidatat non proident.
                        </p>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${productList}" var="product">
                        <div class="col-12 col-md-4 mb-4">
                            <div class="card h-100">
                                <a href="ProductDetailServlet?product_id=${product.id}">
                                    <img src="${product.img}" class="card-img-top" alt="...">
                                </a>
                                <div class="card-body">
                                    <ul class="list-unstyled d-flex justify-content-between">
                                        <li>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-warning fa fa-star"></i>
                                            <i class="text-muted fa fa-star"></i>
                                            <i class="text-muted fa fa-star"></i>
                                        </li>
                                        <li class="text-muted text-right">$240.00</li>
                                    </ul>
                                    <a href="ProductDetailServlet?product_id=${product.id}" class="h2 text-decoration-none text-dark">${product.name}</a>
                                    <p class="card-text">
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt in culpa qui officia deserunt.
                                    </p>
                                    <p class="text-muted">Reviews (24)</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </section>
        <%@include file="./inc/footer.jsp" %>
        <script src="./assets/js/jquery-1.11.0.min.js"></script>
        <script src="./assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="./assets/js/bootstrap.bundle.min.js"></script>
        <script src="./assets/js/templatemo.js"></script>
        <script src="./assets/js/custom.js"></script>
    </body>
</html>