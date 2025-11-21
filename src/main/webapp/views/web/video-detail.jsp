<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<title>${video.title}</title>

<div class="card shadow-sm">
    <div class="card-body p-0">
        <div class="ratio ratio-16x9 bg-black">
            <iframe src="https://www.youtube.com/embed/${video.videoId}" title="YouTube video player" allowfullscreen></iframe>
            
            </div>
    </div>
    <div class="card-body">
        <h3 class="card-title text-primary">${video.title}</h3>
        <hr>
        <div class="d-flex justify-content-between text-secondary mb-3">
            <span><i class="fas fa-calendar-alt"></i> Ngày đăng: Hôm nay</span>
            <span><i class="fas fa-eye"></i> ${video.views} lượt xem</span>
        </div>
        
        <div class="alert alert-light border">
            <h5>Mô tả:</h5>
            <p class="mb-0">${video.description}</p>
        </div>
        
        <div class="mt-4">
            <button class="btn btn-outline-danger me-2"><i class="far fa-heart"></i> Yêu thích</button>
            <button class="btn btn-outline-primary"><i class="fas fa-share-alt"></i> Chia sẻ</button>
        </div>
    </div>
</div>

<div class="mt-4">
    <h5>Bình luận:</h5>
    <div class="card">
        <div class="card-body">
            Chức năng bình luận đang phát triển...
        </div>
    </div>
</div>