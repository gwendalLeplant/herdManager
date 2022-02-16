import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { data, MiscService } from '../services/misc.services';
import { SheepService } from '../services/sheep.services';

export class Genotype{	
	public locusSpotted1Id!:number;	
	public locusSpotted2Id!:number;
	public locusBrown1Id!:number;
	public locusBrown2Id!:number;
	public locusAgouti1Id!:number;
	public locusAgouti2Id!:number;
	public locusFaded1Id!:number;
	public locusFaded2Id!:number;

  constructor(){};
}

export class Sheep{
  public color!: number;
  public race!: number;
  public gender!: number;
  public birthDate!: Date;
  public comments!: string;
  public name!: string;
  public registrationNumber!: string;
  public motherRegistrationNumber!: string;
  public fatherRegistrationNumber!: string;
  public photoNumber!: number;
  public photoName!: string;
  public alias!: string;
  public birthYear!: number;
  public deathDate!: Date;
  public breeder!: number;
  public owner!: number;
  public genotype!: Genotype;
  public carrierOf!: number;
  public sheepId!: number;
  
  constructor()
  {}
}

@Component({
  selector: 'app-new-sheep',
  templateUrl: './new-sheep.component.html',
  styleUrls: ['./new-sheep.component.scss']
})
export class NewSheepComponent implements OnInit, OnDestroy {

  sheeps:any[] = [];
  colors:any[] = [];
  races:any[] = [];
  persons:any[] = [];
  locusBrown:any[] = [];
  locusAgouti:any[] = [];
  locusFaded:any[] = [];
  locusSpotted:any[] = [];
  sheepSelected:any;
  sheepSubscription!:Subscription;
  colorSubscription!:Subscription;
  raceSubscription!:Subscription;
  personSubscription!:Subscription;
  locusBrownSubscription!:Subscription;
  locusAgoutiSubscription!:Subscription;
  locusSpottedSubscription!:Subscription;
  locusFadedSubscription!:Subscription;

  constructor(private sheepService:SheepService, public miscService:MiscService){}
  ngOnDestroy(): void {
    this.sheepSubscription.unsubscribe();
    this.colorSubscription.unsubscribe();
    this.raceSubscription.unsubscribe();
    this.locusBrownSubscription.unsubscribe();
    this.locusAgoutiSubscription.unsubscribe();
    this.locusSpottedSubscription.unsubscribe();
    this.locusFadedSubscription.unsubscribe();
  }


  ngOnInit(): void {
    // Abonnement et mise à jour du tableau
    this.sheepSubscription = this.sheepService.sheepSubject.subscribe((p: any) => {this.sheeps = p;});        
    this.raceSubscription = this.miscService.datasSubject[data.RACE].subscribe((p: any) => {this.races = p;});
    this.colorSubscription = this.miscService.datasSubject[data.COLOR].subscribe((p: any) => {this.colors = p;});
    this.personSubscription = this.miscService.datasSubject[data.PERSON].subscribe((p: any) => {this.persons = p;});
    this.locusAgoutiSubscription = this.miscService.datasSubject[data.LOCUS_AGOUTI].subscribe((p: any) => {this.locusAgouti = p;});
    this.locusBrownSubscription = this.miscService.datasSubject[data.LOCUS_BROWN].subscribe((p: any) => {this.locusBrown = p;});
    this.locusFadedSubscription = this.miscService.datasSubject[data.LOCUS_FADED].subscribe((p: any) => {this.locusFaded = p;});
    this.locusSpottedSubscription = this.miscService.datasSubject[data.LOCUS_SPOTTED].subscribe((p: any) => {this.locusSpotted = p;});
    // Emission de la mise à jour du tableau
    this.miscService.emitSubject(data.RACE,this.races);
    this.miscService.emitSubject(data.COLOR,this.colors);
    this.miscService.emitSubject(data.PERSON,this.persons);
    this.miscService.emitSubject(data.LOCUS_BROWN,this.locusBrown);
    this.miscService.emitSubject(data.LOCUS_AGOUTI,this.locusAgouti);
    this.miscService.emitSubject(data.LOCUS_FADED,this.locusFaded);
    this.miscService.emitSubject(data.LOCUS_SPOTTED,this.locusSpotted);
    this.sheepService.emitSheepSubject();     
    // Récupération de la base de donnée
    this.miscService.getAllFromServer(data.RACE,this.races);
    this.miscService.getAllFromServer(data.COLOR,this.colors);
    this.miscService.getAllFromServer(data.PERSON,this.persons);
    this.miscService.getAllFromServer(data.LOCUS_BROWN,this.locusBrown);
    this.miscService.getAllFromServer(data.LOCUS_AGOUTI,this.locusAgouti);
    this.miscService.getAllFromServer(data.LOCUS_FADED,this.locusFaded);
    this.miscService.getAllFromServer(data.LOCUS_SPOTTED,this.locusSpotted);
    this.sheepService.getAllFromServer();
  }

  powers = [{tag:"Bélier",value:0},{tag:"Brebis",value:1},{tag:"Hermaphrodite",value:2}];

  model = new Sheep();

  modelGenotype = new Genotype();

  submitted = false;

  onSubmit() { 
    this.model.genotype = this.modelGenotype;
    console.log(this.model);
    this.submitted = true; 
  }

  //////// NOT SHOWN IN DOCS ////////

  // Reveal in html:
  //   Name via form.controls = {{showFormControls(heroForm)}}
  showFormControls(form: any) {
  return form && form.controls.name &&
  form.controls.name.value; // Dr. IQ
}

/////////////////////////////

}
