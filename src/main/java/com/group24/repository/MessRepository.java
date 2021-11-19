package com.group24.repository;

import com.group24.models.Mess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessRepository extends JpaRepository<Mess,Long> {

}
