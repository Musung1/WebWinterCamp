package com.example.myboard.repository;

import com.example.myboard.domain.TbBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbBoardRepository extends JpaRepository<TbBoard,String> {

}
