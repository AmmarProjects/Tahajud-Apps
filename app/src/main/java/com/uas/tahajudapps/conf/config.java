package com.uas.tahajudapps.conf;

public class config {
    private static String URL_GET_CONTENT;
    private static String URL_GETID_CONTENT;

    public  static final String getContentID(String id){
        URL_GET_CONTENT = "https://tugas.ammarprojects.com/Tahajud/content/getContent.php?id="+id;
        return URL_GETID_CONTENT;
    }

    public static final String getURL(String id){
        URL_GETID_CONTENT = "https://tugas.ammarprojects.com/Tahajud/content/getid.php?id="+id;
        return URL_GETID_CONTENT;
    }

    public static final String URL_ADD_CONTENT = "https://tugas.ammarprojects.com/Tahajud/content/add.php";
    public static final String URL_UPDATE_CONTENT = "https://tugas.ammarprojects.com/Tahajud/content/update.php";
    public static final String URL_DELETE_CONTENT = "https://tugas.ammarprojects.com/Tahajud/content/delete.php";

    public static final String URL_GET_ARTICLE = "https://tugas.ammarprojects.com/Tahajud/article/index.php";
    public static final String URL_ADD_ARTICLE = "https://tugas.ammarprojects.com/Tahajud/article/add.php";
    public static final String URL_UPDATE_ARTICLE = "https://tugas.ammarprojects.com/Tahajud/article/update.php";
    public static final String URL_DELETE_ARTICLE = "https://tugas.ammarprojects.com/Tahajud/article/delete.php";

    public static final String URL_LOGIN = "https://tugas.ammarprojects.com/Tahajud/article/user/login.php";
    public static final String URL_REGISTER = "https://tugas.ammarprojects.com/Tahajud/article/user/register.php";

    //    CONTENT KEY FOR PHP
    public static final String KEY_CONT_ID = "id_content";
    public static final String KEY_CONT_SUBTITLE = "subtitle_content";
    public static final String KEY_CONT_BODY = "body_content";
    public static final String KEY_CONT_CATEGORY = "id_category";

    //    ARTICLE KEY FOR PHP
    public static final String KEY_ART_ID = "id_article";
    public static final String KEY_ART_TITLE = "title_article";
    public static final String KEY_ART_BODY = "body_article";
    public static final String KEY_ART_IMAGE = "img_article";

    //    JSON TAGS CONTENT
    public static final String JSON_CONTENT="result";
    public static final String CONTENT_ID = "id_content";
    public static final String CONTENT_SUBTITLE = "subtitle_content";
    public static final String CONTENT_BODY = "body_content";
    public static final String CONTENT_CATEGORY = "id_category";

    //    JSON TAGS ARTICLE
    public static final String JSON_ARTICLE="result";
    public static final String ARTICLE_ID = "id_article";
    public static final String ARTICLE_TITLE = "title_article";
    public static final String ARTICLE_BODY = "body_article";
    public static final String ARTICLE_IMAGE = "img_article";

    //    TEMP ID CONTENT
    public static final String CONT_ID = "cont_id";

    //    TEMP ID CONTENT
    public static final String ART_ID = "art_id";

    //LOGINK KEY PHP
    public static final String KEY_USER_ID = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_STATUS= "id_status";
    public static final String KEY_FULLNAME= "fullname";

    //    JSON TAGS LOGIN
    public static final String JSON_LOGIN="result";
    public static final String USER_ID = "id_user";
    public static final String USER_USERNAME = "username";
    public static final String USER_FULLNAME = "fullname";
    public static final String USER_STATUS = "id_status";


}
