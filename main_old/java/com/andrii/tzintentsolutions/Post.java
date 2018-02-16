package com.andrii.tzintentsolutions;

/**
 * Created by Andrii on 15-Jan-18.
 */

class Post {
    String productToCategoryId;
    String categoryId;
    String postId;
    String postName;
    String postImage;
    String postDesk;
    String postDate;
    String postUserId;
    String postStatus;

    Post(String _productToCategoryId, String _categoryId, String _postId, String _postName, String _postImage, String _postDesk, String _postDate, String _postUserId, String _postStatus){
        productToCategoryId = _productToCategoryId;
        categoryId = _categoryId;
        postId = _postId;
        postName = _postName;
        postImage = _postImage;
        postDesk = _postDesk;
        postDate = _postDate;
        postUserId = _postUserId;
        postStatus = _postStatus;
    }
}
