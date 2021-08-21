package kr.or.connect.springmvc.controller;

import kr.or.connect.springmvc.dto.PlusResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlusApiController {

    /**
     * 파라미터로 넘어오는 value1과 value2를 PlusResult 객체에 설정하고
     * 이를 반환하는 핸들러 메소드
     *
     * @param value1
     * @param value2
     * @return
     * @ResponseBody 이 어노테이션이 붙으면 해당 메소드는 View를 리턴하는 것이 아닌, 리턴한 객체를 출력한다.
     */
    @ResponseBody
    @GetMapping("/api/plus")
    public PlusResult plus(@RequestParam("value1") int value1, @RequestParam("value2") int value2) {
        PlusResult plusResult = new PlusResult();
        plusResult.setValue1(value1);
        plusResult.setValue2(value2);
        plusResult.setResult(value1 + value2);

        return plusResult;
    }
}
