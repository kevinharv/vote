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
                                        geographyRepository.findById(Long.parseLong("1")).get()));
                        positions.add(new Position("Governor", "Governor of Texas",
                                        geographyRepository.findById(Long.parseLong("2")).get()));
                        positions.add(new Position("Sheriff", "Sheriff of Collin County",
                                        geographyRepository.findById(Long.parseLong("3")).get()));
                        positions.add(
                                        new Position("Mayor", "Mayor of Dallas",
                                                        geographyRepository.findById(Long.parseLong("4")).get()));
                        positionRepository.saveAll(positions);

                        // Create Politicians
                        log.info("Adding politicians");
                        List<Politician> politicians = new ArrayList<Politician>(8);
                        politicians.add(new Politician("Barack", "Obama",
                                        partyRepository.getPartyByName("Democratic Party"),
                                        geographyRepository.findById(geographies.get(0).getId()).get()));
                        politicians.add(new Politician("Mitt", "Romney",
                                        partyRepository.findById(parties.get(1).getId()).get(),
                                        geographyRepository.findById(geographies.get(0).getId()).get()));
                        politicians.add(new Politician("Greg", "Abbott",
                                        partyRepository.findById(parties.get(1).getId()).get(),
                                        geographyRepository.findById(geographies.get(1).getId()).get()));
                        politicians.add(new Politician("Beto", "O'Rourke",
                                        partyRepository.findById(parties.get(0).getId()).get(),
                                        geographyRepository.findById(geographies.get(1).getId()).get()));
                        politicians.add(new Politician("Foo", "Person",
                                        partyRepository.findById(parties.get(0).getId()).get(),
                                        geographyRepository.findById(geographies.get(2).getId()).get()));
                        politicians.add(new Politician("Bar", "Person",
                                        partyRepository.findById(parties.get(1).getId()).get(),
                                        geographyRepository.findById(geographies.get(2).getId()).get()));
                        politicians.add(new Politician("Fizz", "Politician",
                                        partyRepository.findById(parties.get(0).getId()).get(),
                                        geographyRepository.findById(geographies.get(3).getId()).get()));
                        politicians.add(new Politician("Buzz", "Politician",
                                        partyRepository.findById(parties.get(1).getId()).get(),
                                        geographyRepository.findById(geographies.get(3).getId()).get()));
                        politicianRepository.saveAll(politicians);

                        // Create Elections
                        log.info("Adding elections");
                        Election FedPres2012 = new Election("USA Federal Presidential Election 2012",
                                        new GregorianCalendar(2012, 10, 5, 0, 0).getTime(),
                                        new GregorianCalendar(2012, 10, 6, 0, 0).getTime(),
                                        positionRepository.findById(positions.get(0).getId()).get(),
                                        geographyRepository.findById(geographies.get(0).getId()).get());
                        List<Politician> presidentialCandidates = new ArrayList<Politician>(2);
                        presidentialCandidates.add(politicianRepository.findById(politicians.get(0).getId()).get());
                        presidentialCandidates.add(politicianRepository.findById(politicians.get(1).getId()).get());
                        FedPres2012.setCandidateList(presidentialCandidates);
                        electionRepository.save(FedPres2012);

                        // Create User
                        // Create Voter Registration
                };
        }
}
