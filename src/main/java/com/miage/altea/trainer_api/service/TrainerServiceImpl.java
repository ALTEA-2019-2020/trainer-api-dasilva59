package com.miage.altea.trainer_api.service;

import com.miage.altea.trainer_api.bo.Trainer;
import com.miage.altea.trainer_api.repository.TrainerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class TrainerServiceImpl implements TrainerService {

    private TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Iterable<Trainer> getAllTrainers() {
        return this.trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(String name)  {
        if(this.trainerRepository.findById(name).isPresent())
             return this.trainerRepository.findById(name).get();
        else
            return null;
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        trainer.setPassword(bCryptPasswordEncoder.encode(trainer.getPassword()));
        return this.trainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainer(String name){ this.trainerRepository.deleteById(name);}
}

