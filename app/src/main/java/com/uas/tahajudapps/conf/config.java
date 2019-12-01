package com.uas.tahajudapps.conf;

public class config {
    private static String URL_GETID_CONTENT;

    public static final String getURL(String id){
        URL_GETID_CONTENT = "https://tugas.ammarprojects.com/Tahajud/content/getid.php?id="+id;
        return URL_GETID_CONTENT;
    }

    public static final String URL_ADD_CONTENT = "https://tugas.ammarprojects.com/Tahajud/content/add.php";
    public static final String URL_UPDATE_CONTENT = "https://tugas.ammarprojects.com/Tahajud/content/update.php";
    public static final String URL_DELETE_CONTENT = "https://tugas.ammarprojects.com/Tahajud/content/delete.php";

    private static String URL_GET_ARTICLE_ID;

    public static final String getArtikelID(String id){
        URL_GET_ARTICLE_ID = "https://tugas.ammarprojects.com/Tahajud/article/getArticle.php?id="+id;
        return URL_GET_ARTICLE_ID;
    }

    public static final String URL_GET_ARTICLE = "https://tugas.ammarprojects.com/Tahajud/article/index.php";

    public static final String URL_ADD_ARTICLE = "https://tugas.ammarprojects.com/Tahajud/article/add.php";
    public static final String URL_UPDATE_ARTICLE = "https://tugas.ammarprojects.com/Tahajud/article/update.php";
    public static final String URL_DELETE_ARTICLE = "https://tugas.ammarprojects.com/Tahajud/article/delete.php";

    public static final String URL_LOGIN = "https://tugas.ammarprojects.com/Tahajud/article/user/login.php";
    public static final String URL_REGISTER = "https://tugas.ammarprojects.com/Tahajud/article/user/register.php";
}
