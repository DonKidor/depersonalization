package com.big_case_club.depersonalization.controller;

import com.big_case_club.depersonalization.model.depersonalize.DepersonalizeData;
import com.big_case_club.depersonalization.model.personalize.PersonalizeData;
import com.big_case_club.depersonalization.service.DepersonalizeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/database/depersonalize")
public class DepersonalizeDataController {

    private final DepersonalizeDataService depersonalizeDataService;

    @Autowired
    public DepersonalizeDataController(DepersonalizeDataService depersonalizeDataService) {
        this.depersonalizeDataService = depersonalizeDataService;
    }

    @GetMapping("/view")
    public @ResponseBody
    List<DepersonalizeData> viewDatabase(@RequestParam("sorted") String sorted, @RequestParam("page") int page, @RequestParam("direction") String direction) {
        Sort.Direction dir = Sort.Direction.ASC;
        if(direction.equals("DESC")) dir = Sort.Direction.DESC;
        return depersonalizeDataService.viewDatabase(Sort.by(dir, sorted), page);
    }

    @RequestMapping(value="search", method = RequestMethod.GET)
    public @ResponseBody
    List<DepersonalizeData> viewDatabase(@RequestParam("searchField") String field, @RequestParam("searchData") String searchData,
                                       @RequestParam("sorted") String sorted, @RequestParam("page") int page, @RequestParam("direction") String direction) {
        Sort.Direction dir=Sort.Direction.ASC;
        if(direction.equals("DESC")) dir= Sort.Direction.DESC;
        return depersonalizeDataService.searchDatabase(field, searchData, Sort.by(dir, sorted), page);
    }
    @GetMapping("/pages")
    public @ResponseBody int getPages() {
        return depersonalizeDataService.getTotalPages();
    }

    @PostMapping("/save")
    public @ResponseBody
    DepersonalizeData createData(@RequestBody DepersonalizeData depersonalizeData) {
        return depersonalizeDataService.saveData(depersonalizeData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepersonalizeData> getDataById(@PathVariable Long id) {
        DepersonalizeData foundDepersonalizeData = depersonalizeDataService.findDataById(id);
        if(foundDepersonalizeData != null){
            return ResponseEntity.ok(foundDepersonalizeData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepersonalizeData> updateData(@PathVariable Long id, @RequestBody DepersonalizeData depersonalizeData) {
        DepersonalizeData updatedDepersonalizeData = depersonalizeDataService.updateData(depersonalizeData,id);
        if(updatedDepersonalizeData != null){
            return ResponseEntity.ok(updatedDepersonalizeData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteData(@PathVariable Long id) {
        depersonalizeDataService.deleteDataById(id);
        return ResponseEntity.ok().build();
    }
}
