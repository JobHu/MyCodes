package ycit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ycit.pojo.Problem;
import ycit.pojo.ProblemComment;
import ycit.pojo.ProblemCommentReply;
import ycit.pojo.User;
import ycit.service.IProblemCommentReplyService;
import ycit.service.IProblemCommentService;
import ycit.service.IProblemService;
/**
 * 问题的控制器
 * @author hyg
 *
 */
@Controller
@RequestMapping("/problem")
public class ProblemController {
	
	@Autowired
	private IProblemService problemService;
	@Autowired 
	private IProblemCommentService problemCommentService;
	@Autowired
	private IProblemCommentReplyService problemCommentReplyService;
          
	//去到添加问题的页面
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "/faceToface/add";
	}
	//真正的添加页面
	@RequestMapping("/add")
	public String add(HttpSession session,Problem problem){
		
	  User user = 	(User) session.getAttribute("myuser");
	  int uId = user.getId();
	  problem.setuId(uId);
	  
	  boolean sucFlag =   problemService.insertProblem(problem);
	  if (sucFlag) {
		return "redirect:/problem/queryAllProblem";
	}
		
		return "/faceToface/add";
	}
	//查询所有的问题问题的名称，问题的内容，问题的点赞数，问题的所有的评论。
	  @RequestMapping("/queryAllProblem")
	  public String queryAllProblem(Model model){
		  
	  List<Problem> problems = problemService.queryAllProblem();
	  model.addAttribute("problems", problems);
	  
	  return "/faceToface/index";	
	}
	  //去到评论的页面
	  @RequestMapping("/comments/{id}")
	  public String toComments(@PathVariable("id")Integer pId,Model model){
		  model.addAttribute("pId", pId);
		return "/faceToface/comments";  
	  }
	  //对某一个问题进行评论
	  @RequestMapping("/comments")
	  public String problemComments(ProblemComment problemComment,HttpSession session){
		  //那个用户进行的评论
		  User user = 	(User) session.getAttribute("myuser");
		  int uId = user.getId();
		  problemComment.setuId(uId);
		  boolean sucFlag = problemCommentService.insertProblemComment(problemComment);
		  if (sucFlag) {
			return "redirect:/problem/queryAllProblem";
		}
		  
		return "";	  
	  }
	  //查看一个问题的所有的评论
	  @RequestMapping("/queryAllProblemComment/{id}")
	  public String queryAllProblemComment(@PathVariable("id")Integer id,Model model){
		  List<ProblemComment> problemComments = problemCommentService.queryAllProblemComment(id);
		  model.addAttribute("problemComments", problemComments);
		  return "/faceToface/allComment";
	  }
	  //点赞提出的问题的功能
	  @RequestMapping("/thumbs/{id}")
	  public String thumbs(@PathVariable("id")Integer id){
		  
		  boolean sucFlag = problemService.updateThumbs(id);
		  if (sucFlag) {
			return "redirect:/problem/queryAllProblem";
			
		}
		return null;
	  }
	  //去到评论的评论的页面
	  @RequestMapping("/toProblemCommentReply/{id}")
	  public String toProblemCommentReply(@PathVariable("id")Integer id,Model model){
		 model.addAttribute("pCId", id);
		return "/faceToface/addComment";
		  
	  }
	  //对评论的内容进行评论
	  @RequestMapping("/problemCommentReply")
	  public String  problemCommentReply(HttpSession session,ProblemCommentReply problemCommentReply){
		  User user = (User) session.getAttribute("myuser");
		  Integer uId = user.getId();
		  problemCommentReply.setuId(uId);
		  boolean sucFlag = problemCommentReplyService.insertProblemCommentReply(problemCommentReply);
		  if (sucFlag) {
			return "redirect:/problem/queryAllProblemCommentReply/"+problemCommentReply.getCommentId();
		}
		return null;
	  }
	  //查看所有的回复
	  @RequestMapping("/queryAllProblemCommentReply/{id}")
	  public String queryAllProblemCommentReply(@PathVariable("id")Integer id,Model model){
		  List<ProblemCommentReply> problemCommentReplys = problemCommentReplyService.queryAllProblemCommentReply(id);
		 model.addAttribute("problemCommentReplys", problemCommentReplys);
		return "/faceToface/reply";  
	  }
	
}
