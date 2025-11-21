<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
    <div class="container">
        <a class="navbar-brand" href="<c:url value='/home'/>">
            <i class="fa-solid fa-film"></i> IoTStar Video
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="<c:url value='/home'/>">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/videos'/>">Danh sách Video</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Liên hệ</a>
                </li>
            </ul>

            <form class="d-flex me-3" action="search" method="get">
                <input class="form-control me-2" type="search" placeholder="Tìm video..." aria-label="Search">
                <button class="btn btn-outline-light" type="submit">Tìm</button>
            </form>

            <ul class="navbar-nav">
                <c:if test="${sessionScope.currentUser == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/login'/>">Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/register'/>">Đăng ký</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.currentUser != null}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown">
                            Xin chào, ${sessionScope.currentUser.fullname}
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="<c:url value='/profile'/>">Hồ sơ của tôi</a></li>
                            <li><a class="dropdown-item" href="<c:url value='/change-password'/>">Đổi mật khẩu</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item text-danger" href="<c:url value='/logout'/>">Đăng xuất</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>