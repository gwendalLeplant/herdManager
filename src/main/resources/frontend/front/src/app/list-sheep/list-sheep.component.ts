import { Component, Input} from '@angular/core';
import { SheepService } from '../services/sheep.services';

@Component({
  selector: 'app-list-sheep',
  templateUrl: './list-sheep.component.html',
  styleUrls: ['./list-sheep.component.scss']
})
export class ListSheepComponent  {

  @Input() sheeps:any[] = [];
  sheepsSelected:any[] = [];
  strToSearch = '';
  idToDisplay:number = 0;


  constructor(private sheepService:SheepService) { }

  onChangeSheepSelected(){
    if(this.strToSearch!=''){
      this.sheepsSelected = [];
      for(let sheep of this.sheeps){
        if(sheep.name.toLowerCase().includes(this.strToSearch.toLowerCase())||sheep.registrationNumber.toLowerCase().includes(this.strToSearch.toLowerCase())){
          this.sheepsSelected.push(sheep);
        }
      }
    }
  }

  onDisplaySheep(id:number){
    this.sheepService.setSheepSelected(id);
  }

}
