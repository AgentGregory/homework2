package com.agentgregory.homework2.controller;

import com.agentgregory.homework2.model.FileNode;
import com.agentgregory.homework2.model.FileNodeEntity;
import com.agentgregory.homework2.repository.FileNodeRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class Controller {
    private final FileNodeRepositoryService fileNodeRepositoryService;


    @PostMapping("/fill")
    public ResponseEntity<?> save(@RequestBody FileNode fileNode) {
        fileNodeRepositoryService.save(fileNode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find?name=")
    ResponseEntity<?> constructPath(@RequestParam String name, String rootPath) {
        String constructPath = fileNodeRepositoryService.constructPath(name, rootPath);
        return new ResponseEntity<>(constructPath, HttpStatus.OK);
    }
}
