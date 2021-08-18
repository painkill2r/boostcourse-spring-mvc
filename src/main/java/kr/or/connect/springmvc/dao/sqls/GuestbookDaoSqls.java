package kr.or.connect.springmvc.dao.sqls;

/**
 * Guestbook SQL 상수 정의
 */
public class GuestbookDaoSqls {

    public static final String SELECT_COUNT = "SELECT COUNT(*) FROM boost_guestbook WHERE 1 = 1";
    public static final String SELECT_PAGING = "SELECT id, name, content, regdate FROM boost_guestbook WHERE 1 = 1 ORDRE BY id DESC LIMIT :start, :limit";
    public static final String DELETE_BY_ID = "DELTE FROM boost_guestbook WHERE 1 = 1 AND id = :id";
}
