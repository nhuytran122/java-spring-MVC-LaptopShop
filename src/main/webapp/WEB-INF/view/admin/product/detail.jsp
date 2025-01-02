<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
    <meta name="author" content="Hỏi Dân IT" />
    <title>Dashboard - Hỏi Dân IT</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp" />
    <div id="layoutSidenav">
        <jsp:include page="../layout/sidebar.jsp" />
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Manage Products</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"> <a href="/admin">Dashboard</a></li>
                        <li class="breadcrumb-item"><a href="/admin/product">Product</a></li>
                        <li class="breadcrumb-item active">View detail</li>
                    </ol>
                    <div class="container mt-5">
                        <div class="row">
                            <div class="col-9 mx-auto">
                                <div class="d-flex justify-content-between">
                                    <h3>Product Detail with id = ${pr.id}</h3>
                                </div>
                                <hr />

                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="card">
                                            <div class="card-header">
                                                Product Information
                                            </div>
                                            <ul class="list-group list-group-flush">
                                                <li class="list-group-item">
                                                    <div class="row">
                                                        <div class="col-md-4"><strong>ID:</strong></div>
                                                        <div class="col-md-8">${pr.id}</div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item">
                                                    <div class="row">
                                                        <div class="col-md-4"><strong>Name:</strong></div>
                                                        <div class="col-md-8">${pr.name}</div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item">
                                                    <div class="row">
                                                        <div class="col-md-4"><strong>Price:</strong></div>
                                                        <div class="col-md-8">
                                                            <fmt:formatNumber type="number" value="${pr.price}" /> đ
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item">
                                                    <div class="row">
                                                        <div class="col-md-4"><strong>Quantity:</strong></div>
                                                        <div class="col-md-8">${pr.quantity}</div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item">
                                                    <div class="row">
                                                        <div class="col-md-4"><strong>Factory:</strong></div>
                                                        <div class="col-md-8">${pr.factory}</div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item">
                                                    <div class="row">
                                                        <div class="col-md-4"><strong>Target:</strong></div>
                                                        <div class="col-md-8">${pr.target}</div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item">
                                                    <div class="row">
                                                        <div class="col-md-4"><strong>Detail Description:</strong></div>
                                                        <div class="col-md-8">${pr.detailDesc}</div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item">
                                                    <div class="row">
                                                        <div class="col-md-4"><strong>Short Description:</strong></div>
                                                        <div class="col-md-8">${pr.shortDesc}</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <img src="/images/product/${pr.image}" alt="Product Image"
                                            style="width: 100%; height: auto;">
                                    </div>
                                </div>

                                <a href="/admin/product" class="btn btn-success mt-3">Back</a>
                            </div>
                        </div>
                    </div>

            </main>
            <jsp:include page="../layout/footer.jsp" />
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="/js/scripts.js"></script>
</body>

</html>
