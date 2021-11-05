package com.training.reportmanagementservice_AP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "port_gen", sequenceName = "port_gen", initialValue =11000)
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "port_gen")
	private int id;
	private int participation;
	private int interaction;
	private int understanding;
	private int implementation;
	private int batchId;
	/**
	 * 
	 */
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param participation
	 * @param interaction
	 * @param understanding
	 * @param implementation
	 * @param batchId
	 */
	public Report(int id, int participation, int interaction, int understanding, int implementation, int batchId) {
		super();
		this.id = id;
		this.participation = participation;
		this.interaction = interaction;
		this.understanding = understanding;
		this.implementation = implementation;
		this.batchId = batchId;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the participation
	 */
	public int getParticipation() {
		return participation;
	}
	/**
	 * @param participation the participation to set
	 */
	public void setParticipation(int participation) {
		this.participation = participation;
	}
	/**
	 * @return the interaction
	 */
	public int getInteraction() {
		return interaction;
	}
	/**
	 * @param interaction the interaction to set
	 */
	public void setInteraction(int interaction) {
		this.interaction = interaction;
	}
	/**
	 * @return the understanding
	 */
	public int getUnderstanding() {
		return understanding;
	}
	/**
	 * @param understanding the understanding to set
	 */
	public void setUnderstanding(int understanding) {
		this.understanding = understanding;
	}
	/**
	 * @return the implementation
	 */
	public int getImplementation() {
		return implementation;
	}
	/**
	 * @param implementation the implementation to set
	 */
	public void setImplementation(int implementation) {
		this.implementation = implementation;
	}
	/**
	 * @return the batchId
	 */
	public int getBatchId() {
		return batchId;
	}
	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", participation=" + participation + ", interaction=" + interaction
				+ ", understanding=" + understanding + ", implementation=" + implementation + ", batchId=" + batchId
				+ "]";
	}
	

	
	
	

}
