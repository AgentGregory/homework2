package com.agentgregory.homework2.model;

import lombok.Value;

import java.util.List;

@Value//check lombok.@Value
public class FileNode {
    Long id;
    Long parentId;
    String name;
    List<FileNode> children;
}
