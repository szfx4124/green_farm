package cn.nchu.green_farm.controller;

import cn.nchu.green_farm.entity.Comment;
import cn.nchu.green_farm.service.ICommentService;
import cn.nchu.green_farm.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jianhzhong
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/relase")
    public ResponseResult<Void> handleReg(Comment comment) {
        commentService.reg(comment);
        return new ResponseResult<>(SUCCESS);
    }
    @PostMapping("/list")
    public ResponseResult<List<Comment>> handleList() {
        List<Comment> list =  commentService.getList();
        return new ResponseResult<>(SUCCESS,list);
    }
}