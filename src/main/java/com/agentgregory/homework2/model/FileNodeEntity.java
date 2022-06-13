package com.agentgregory.homework2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "file_nodes")
public class FileNodeEntity {
    @Id
    private Long id;
    private Long parentId;
    private String name;
}
