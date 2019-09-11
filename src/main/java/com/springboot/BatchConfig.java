/*package com.springboot;

import java.io.File;

import javax.batch.runtime.JobExecution;
import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.springboot.model.Appointment;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired EntityManagerFactory factory;
	@Bean @StepScope public FlatFileItemReader<Appointment> reader(@Value("#{jobParameters(file)}") File file){
		FlatFileItemReader<Appointment> reader= new FlatFileItemReader<>();
		reader.setResource(new FileSystemResource(file));
		reader.setLineMapper(new DefaultLineMapper<Appointment>(){
			{
				this.setLineTokenizer(new DelimitedLineTokenizer() {
					{
						this.setDelimiter(",");
					//	this.setNames(new String[] {"patientid"});
						
					}
				});
				this.setFieldSetMapper(new BeanWrapperFieldSetMapper<Appointment>(){
					{
						this.setTargetType(Appointment.class);
					}
				});
			}
		});
		return null;
	}
	
	@Bean
	public CommandLineRunner runner(JobLauncher launcher, Job job, @Value("#{file}") File file){
		return (String[] app)->{
			org.springframework.batch.core.JobExecution exec=launcher.run(job, new JobParametersBuilder().addString("file", file.getAbsolutePath()).toJobParameters());
			System.out.println(exec.getExitStatus().toString());
		};
	};
	@Bean public JpaItemWriter<Appointment> writer() {
		JpaItemWriter<Appointment> writer= new JpaItemWriter<>();
		writer.setEntityManagerFactory(factory);
		//writer.write(items);
		return writer;
	}
	@Bean
	public Job job(JobBuilderFactory jfactory, StepBuilderFactory sfactory) {
		Step step1= sfactory.get("file-to-database").<Appointment, Appointment>chunk(3).reader(reader()).writer(writer()).build();
		return jfactory.get("job1").start(step1).build();
	}
}
*/