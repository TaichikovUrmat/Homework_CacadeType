package java12.service;

import java12.entit.Addresses;
import java12.entit.Companies;
import java12.entit.Programmer;
import java12.entit.Project;

import java.util.List;

public interface ProgrammerService {

    // crud

    // creat
    String saveProgrammer(Programmer programmer);

    Addresses getProgrammerByID(Long programmerId);
    List<Programmer> getAllProgrammer();
    String updateProgrammer(Long oldProgrammer , Programmer newProgrammer);

    String deleteProgrammer(Long id);

}
