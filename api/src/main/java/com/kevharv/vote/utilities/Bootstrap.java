package com.kevharv.vote.utilities;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kevharv.vote.VoteApplication;
import com.kevharv.vote.models.Election;
import com.kevharv.vote.models.Geography;
import com.kevharv.vote.models.GeographyType;
import com.kevharv.vote.models.PoliticalParty;
import com.kevharv.vote.models.Politician;
import com.kevharv.vote.models.Position;
import com.kevharv.vote.repositories.ElectionRepository;
import com.kevharv.vote.repositories.GeographyRepository;
import com.kevharv.vote.repositories.PoliticalPartyRepository;
import com.kevharv.vote.repositories.PoliticianRepository;
import com.kevharv.vote.repositories.PositionRepository;
import com.kevharv.vote.repositories.UserRepository;
import com.kevharv.vote.repositories.VoterRegistrationRepository;

@Configuration
public class Bootstrap {

        private static final Logger log = LoggerFactory.getLogger(VoteApplication.class);
        @Value("${debug.bootstrap.force}")
        private boolean forceBootstrap;

        @Bean
        public CommandLineRunner bootstrapDataset(
                        ElectionRepository electionRepository,
                        GeographyRepository geographyRepository,
                        PoliticalPartyRepository partyRepository,
                        PoliticianRepository politicianRepository,
                        PositionRepository positionRepository,
                        UserRepository userRepository,
                        VoterRegistrationRepository voterRegistrationRepository) {
                return (args) -> {
                        // Only bootstrap if there is no data - check with parties
                        if ((partyRepository.count() > 0) && (!forceBootstrap)) {
                                return;
                        }

                        if (forceBootstrap) {
                                log.info("Deleting objects if they exist");
                                electionRepository.deleteAll();
                                politicianRepository.deleteAll();
                                positionRepository.deleteAll();
                                geographyRepository.deleteAll();
                                partyRepository.deleteAll();
                                userRepository.deleteAll();
                                voterRegistrationRepository.deleteAll();
                        }

                        // Create Political Parties
                        log.info("Adding political parties");
                        List<PoliticalParty> parties = new ArrayList<PoliticalParty>(5);
                        parties.add(new PoliticalParty("Democratic Party"));
                        parties.add(new PoliticalParty("Republican Party"));
                        parties.add(new PoliticalParty("Libertarian Party"));
                        parties.add(new PoliticalParty("Green Party"));
                        parties.add(new PoliticalParty("Independent"));
                        partyRepository.saveAll(parties);

                        // Create Geographies
                        log.info("Adding geographies");
                        List<Geography> geographies = new ArrayList<Geography>(4);
                        geographies.add(new Geography("The United States of America", GeographyType.COUNTRY));
                        geographies.add(new Geography("Texas", GeographyType.STATE));
                        geographies.add(new Geography("Collin", GeographyType.COUNTY));
                        geographies.add(new Geography("Dallas", GeographyType.MUNICIPALITY));
                        geographyRepository.saveAll(geographies);

                        // Create Positions
                        log.info("Adding positions");
                        List<Position> positions = new ArrayList<Position>(4);
                        positions.add(new Position("President", "President of The United States of America",
                                        geographyRepository.findByName("The United States of America")));
                        positions.add(new Position("Governor", "Governor of Texas",
                                        geographyRepository.findByName("Texas")));
                        positions.add(new Position("Sheriff", "Sheriff of Collin County",
                                        geographyRepository.findByName("Collin")));
                        positions.add(
                                        new Position("Mayor", "Mayor of Dallas",
                                                        geographyRepository.findByName("Dallas")));
                        positionRepository.saveAll(positions);

                        // Create Politicians
                        log.info("Adding politicians");
                        List<Politician> politicians = new ArrayList<Politician>(8);
                        politicians.add(new Politician("Barack", "Obama",
                                        partyRepository.findByName("Democratic Party"),
                                        geographyRepository.findByName("The United States of America")));
                        politicians.add(new Politician("Mitt", "Romney",
                                        partyRepository.findByName("Republican Party"),
                                        geographyRepository.findByName("The United States of America")));
                        politicians.add(new Politician("Greg", "Abbott",
                                        partyRepository.findByName("Republican Party"),
                                        geographyRepository.findByName("Texas")));
                        politicians.add(new Politician("Beto", "O'Rourke",
                                        partyRepository.findByName("Democratic Party"),
                                        geographyRepository.findByName("Texas")));
                        politicians.add(new Politician("Foo", "Person",
                                        partyRepository.findByName("Democratic Party"),
                                        geographyRepository.findByName("Collin")));
                        politicians.add(new Politician("Bar", "Person",
                                        partyRepository.findByName("Republican Party"),
                                        geographyRepository.findByName("Collin")));
                        politicians.add(new Politician("Fizz", "Politician",
                                        partyRepository.findByName("Republican Party"),
                                        geographyRepository.findByName("Dallas")));
                        politicians.add(new Politician("Buzz", "Politician",
                                        partyRepository.findByName("Democratic Party"),
                                        geographyRepository.findByName("Dallas")));
                        politicianRepository.saveAll(politicians);

                        // Create Elections
                        log.info("Adding elections");
                        Election FedPres2012 = new Election("USA Federal Presidential Election 2012",
                                        new GregorianCalendar(2012, 10, 5, 0, 0).getTime(),
                                        new GregorianCalendar(2012, 10, 6, 0, 0).getTime(),
                                        positionRepository.findByName("President"),
                                        geographyRepository.findByName("The United States of America"));
                        log.info("Adding candidates");
                        List<Politician> presidentialCandidates = new ArrayList<Politician>(2);
                        presidentialCandidates.add(politicianRepository.findByLastName("Romney"));
                        presidentialCandidates.add(politicianRepository.findByLastName("Obama"));
                        log.info("Created candidate list");
                        FedPres2012.setCandidateList(presidentialCandidates);
                        electionRepository.save(FedPres2012);

                        // Create User
                        // Create Voter Registration

                        log.info("Bootstrap complete");
                };
        }
}
