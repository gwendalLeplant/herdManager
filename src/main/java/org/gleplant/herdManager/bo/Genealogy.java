package org.gleplant.herdManager.bo;

public class Genealogy {
	private Sheep child;
	private Sheep mother;
	private Sheep father;

	public Genealogy() {
	}

	public Genealogy(Sheep child, Sheep mother, Sheep father) {
		this.child = child;
		this.mother = mother;
		this.father = father;
	}

	/**
	 * @return the child
	 */
	public Sheep getChild() {
		return child;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(Sheep child) {
		this.child = child;
	}

	/**
	 * @return the mother
	 */
	public Sheep getMother() {
		return mother;
	}

	/**
	 * @param mother the mother to set
	 */
	public void setMother(Sheep mother) {
		this.mother = mother;
	}

	/**
	 * @return the father
	 */
	public Sheep getFather() {
		return father;
	}

	/**
	 * @param father the father to set
	 */
	public void setFather(Sheep father) {
		this.father = father;
	}

	@Override
	public String toString() {
		return "Genealogy [child=" + child + ", mother=" + mother + ", father=" + father + "]";
	}

}
