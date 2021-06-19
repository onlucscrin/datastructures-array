package org.datastructure.arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ArrayDataStructureController {
    ArrayDataStructureService arrayDataStructureService;

    @Autowired
    ArrayDataStructureController(ArrayDataStructureService arrayDataStructureService){
        this.arrayDataStructureService = arrayDataStructureService;
    }

    @PutMapping(path = "/evenArray", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer[]> updateToEvenArray(@RequestBody Integer[] inputArray) {
        try {
            Integer[] result = arrayDataStructureService.getEvenArray(inputArray);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping(path = "/mergeArray", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer[]> mergeArrays(@RequestBody Integer[][] inputArray) {
        try {
            Integer[] result = arrayDataStructureService.mergeArrays(inputArray[0], inputArray[1]);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping(path = "/rearrangePosNeg", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer[]> rearrangePosNegArray(@RequestBody Integer[] inputArray){
        try{
            Integer[] result = arrayDataStructureService.rearrangePosNegArray(inputArray);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
