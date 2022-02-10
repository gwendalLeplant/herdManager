import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subject, Subscription } from 'rxjs';
import { ListSheepComponent } from '../list-sheep/list-sheep.component';
import { SheepService } from '../services/sheep.services';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  sheeps:any[] = [];
  sheepSelected:any;
  selectedSheepSubscription!:Subscription;
  sheepSubscription!:Subscription;

  constructor(private sheepService:SheepService) { }

  ngOnDestroy(): void {
    this.sheepSubscription.unsubscribe();
    this.selectedSheepSubscription.unsubscribe();
  }


  ngOnInit(): void {
    // Abonnement et mise à jour du tableau
    this.sheepSubscription = this.sheepService.sheepSubject.subscribe(
        (p: any) => {
        this.sheeps = p;
        }
    );        
    // Emission de la mise à jour du tableau
    this.sheepService.emitSheepSubject();     
    this.selectedSheepSubscription = this.sheepService.selectedSheepSubject.subscribe(
      (p: any) => {
      this.sheepSelected = p;
      }
    )  
    this.sheepService.emitSelectedSheepSubject();
    // Récupération de la base de donnée
    this.sheepService.getAllFromServer();
  }

}
