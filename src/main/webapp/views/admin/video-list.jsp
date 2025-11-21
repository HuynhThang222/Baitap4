<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<title>Quản lý Video</title>

<div class="card shadow mb-4">
    <div class="card-header py-3 d-flex justify-content-between align-items-center">
        <h6 class="m-0 font-weight-bold text-primary">Danh Sách Video</h6>
        
        <form action="<c:url value='/admin/videos'/>" method="get" class="d-flex">
            <input class="form-control form-control-sm me-2" type="search" 
                   name="keyword" value="${searchKeyword}" placeholder="Tìm theo tiêu đề...">
            <button class="btn btn-primary btn-sm" type="submit"><i class="fas fa-search"></i></button>
        </form>
    </div>
    
    <div class="card-body">
        <c:if test="${not empty message}">
            <div class="alert alert-info">${message}</div>
        </c:if>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Video ID</th>
                    <th>Tiêu đề</th>
                    <th>Poster</th>
                    <th>Lượt xem</th>
                    <th>Thể loại</th>
                    <th>Trạng thái</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${videos}" var="v">
                    <tr>
                        <td>${v.videoId}</td>
                        <td>${v.title}</td>
                        <td>
                             <img src="${v.poster}" width="100" class="img-fluid" onerror="this.src='https://via.placeholder.com/100'"/>
                        </td>
                        <td>${v.views}</td>
                        <td>${v.category.categoryName}</td>
                        <td>
                            <span class="badge ${v.active ? 'bg-success' : 'bg-danger'}">
                                ${v.active ? 'Hiện' : 'Ẩn'}
                            </span>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <c:if test="${empty videos}">
            <div class="text-center py-3">Không tìm thấy video nào.</div>
        </c:if>
    </div>
</div>