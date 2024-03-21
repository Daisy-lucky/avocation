package com.my.avocation.repository;

import com.my.avocation.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label,Long>{
    Label findLabelById(Integer id);
}
