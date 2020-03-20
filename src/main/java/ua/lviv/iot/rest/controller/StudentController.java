package ua.lviv.iot.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.rest.model.Student;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping ("/students")
@RestController
public class StudentController {

    private Map<Integer, Student> studentMap = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public List<Student> getAllStd(){
        return new LinkedList<>(studentMap.values());
    }
   @GetMapping (path = "/{id}")
   public Student getStudent(@PathVariable ("id") Integer studentID){
       System.out.println(studentID);
       return studentMap.get(studentID);
   }

   @PostMapping (produces = {MediaType.APPLICATION_JSON_VALUE, "application/xml;charset=UTF-8"})
    public Student getMoldovanStudent(@RequestBody Student student){
       student.setId(idCounter.incrementAndGet());
       studentMap.put(student.getId(), student);
       return student;
   }

   @DeleteMapping (path = "/{id}")
    public ResponseEntity<Student> MOldova(@PathVariable ("id") Integer idToDelete) {
       HttpStatus status = (studentMap.remove(idToDelete) == null) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
       return ResponseEntity.status(status).build();
   }

    @PutMapping (path = "/{id}")
    public ResponseEntity<Student> update(final @PathVariable("id") Integer studentId,
                                         final @RequestBody Student student) {
        if(studentMap.get(studentId)==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
        student.setId(studentId);
        studentMap.put(studentId, student);
        return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
}
