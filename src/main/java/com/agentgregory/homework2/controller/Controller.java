package com.agentgregory.homework2.controller;

import com.agentgregory.homework2.model.FileNode;
import com.agentgregory.homework2.model.FileNodeEntity;
import com.agentgregory.homework2.repository.FileNodeRepository;
import com.agentgregory.homework2.repository.FileNodeRepositoryService;
import com.agentgregory.homework2.service.FileComputer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;


@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final FileComputer fileComputer;
    private final FileNodeRepositoryService fileNodeRepositoryService;

    @GetMapping("/localhost/files/fill")
    public FileNode fillDB (@RequestBody File rootPath, Long id){
        return fileComputer.searchFileNode(rootPath, id);
    }

    @GetMapping(" /localhost/files/find?name=")
    public String searchName(@RequestBody String name, String rootPath){
        return fileNodeRepositoryService.constructPath(name, rootPath);

    }
}
