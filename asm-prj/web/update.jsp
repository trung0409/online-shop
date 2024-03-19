
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="./assets/style.css">
        <title>Update</title>
    </head>
    <body>
        
       <c:set var= "p" value="${requestScope.product}"/>
       
        <div class="col-md-6 offset-md-3 ">
            <span class="anchor" id="formChangePassword"></span>
            <hr class="mb-5">

            <!-- form card change password -->
            <div class="card card-outline-secondary">
                <div class="card-header">
                    <h3 class="mb-0">Update Information Product</h3>
                </div>
                <div class="card-body">
                    <form class="form" role="form" autocomplete="off" action="update" method="post">
                        <div class="form-group" style="display: none;">
                            <label for="id">ID</label>
                            <input type="text" class="form-control" id="id" required="" value="${p.id}" name="id">
                        </div>
                        <div class="form-group">
                            <label for="Name">Name</label>
                            <input type="text" class="form-control" id="Name" required="" value="${p.name}" name="name">
                        </div>
                        <div class="form-group">
                            <label for="Image">Image</label>
                            <input type="text" class="form-control" id="Image" required="" value="${p.image}" name="image" accept="image/*">
                        </div>
                        <div class="form-group">
                            <label for="Price">Price</label>
                            <input type="number" class="form-control" id="Price" required="" value="${p.price}" name="price" min="1000" max="100000000">
                        </div>
                        <div class="form-group">
                            <label for="Discount">Discount</label>
                            <input type="number" class="form-control" id="Discount" required="" value="${p.discount}" name="discount" min="0" max="100">
                        </div>
                        <div class="form-group">
                            <label for="Quantity">Quantity</label>
                            <input type="number" class="form-control" id="Quantity" required="" value="${p.quantity}" name="quantity" min="1" max="1000">
                        </div>
                        <div class="form-group">
                            <label for="Detail">Detail</label>
                            <textarea type="text" class="form-control" id="Detail" required=""  name="detail" rows="5">${p.detail}</textarea>
                        </div>
                        <div class="form-group">
                            <label for="Information">Information</label>
                            <textarea type="text" class="form-control" id="Information" required=""  name="information" rows="5">${p.information}</textarea>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success btn-lg float-right">Save</button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- /form card change password -->

        </div>








        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>
</html>
