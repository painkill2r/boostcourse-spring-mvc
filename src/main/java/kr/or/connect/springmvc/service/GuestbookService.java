package kr.or.connect.springmvc.service;

import kr.or.connect.springmvc.dto.Guestbook;

import java.util.List;

public interface GuestbookService {

    static final Integer LIMIT = 5;

    int getCount();

    List<Guestbook> getGuestbooks(Integer start);

    Guestbook addGuestbook(Guestbook guestbook, String ip);

    int deleteGuestbook(Long id, String ip);
}
