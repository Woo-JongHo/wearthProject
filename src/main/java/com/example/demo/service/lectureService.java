package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EducationJpaRepository;
import com.example.demo.repository.EducationMyBatisRepository;
import com.example.demo.repository.LectureJpaRepository;
import com.example.demo.repository.LectureMyBatisRepository;
import com.example.demo.repository.LikedMybatisRepository;
import com.example.demo.repository.ReviewMyBatisRepository;
import com.example.demo.vo.EducationVO;
import com.example.demo.vo.LectureVO;
import com.example.demo.vo.LikedVO;
import com.example.demo.vo.OpinionVO;

import lombok.Setter;

@Service
@Setter
public class lectureService {

	@Autowired
	private LectureJpaRepository dao_JPA;
	
	@Autowired
	private LectureMyBatisRepository dao_MB;
	
	@Autowired
	private LikedMybatisRepository liked_MB;
	
	@Autowired
	private ReviewMyBatisRepository review_MB;

//MB (조회)
	// 총 강의 게시물 수
	public int getTotalLecture(){
		return dao_MB.getTotalLecture();
	}

	// 강의 전체목록 반환
	public List<LectureVO> findAllLecture(){
		return dao_MB.findAllLecture();
	}
	
	public LectureVO findByNoLecture(int lecNO) {
		return dao_MB.findByNoLecture(lecNO);
	}
	
	public int insertLecture(LectureVO l) {
		return dao_MB.insertLecture(l);
	}
	
	//강연 좋아요 추가
	public int insertLectureLiked(HashMap<String, Object> map) {
		return liked_MB.insertLectureLiked(map);
	}
	//강연 좋아요 취소
	public int deleteLectureLiked(HashMap<String, Object> map) {
		return liked_MB.deleteLectureLiked(map);
	}
	// 강연 좋아요목록 조회
	public List<LectureVO> findLikedLectureByUserNo (int userno) {
		return liked_MB.findLikedLectureByUserNo(userno);
	}
	// 좋아요한 버튼 세션 유지를 위한 조회
	public List<Integer> findLikedLectureNos(int userno) {
		return liked_MB.findLikedLectureNos(userno);
	}
// 리뷰
	// 강연 리뷰 조회
	public List<OpinionVO> findAllLectureReview (int lecNO){
		return review_MB.findAllLectureReview(lecNO);
	}
	// 강연 리뷰 등록
	public int insertLectureReview(HashMap<String, Object> map) { 
		return review_MB.insertLectureReview(map);
	}	
	
	//JPA (수정, 삭제)
	
	public void updateLecture(LectureVO l) {
		dao_JPA.save(l);
	}
	
	public void deleteLecture(int lecNO) {
		dao_JPA.deleteById(lecNO);
	}
}
