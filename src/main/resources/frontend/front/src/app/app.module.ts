import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SheepInfoComponent } from './sheep-info/sheep-info.component';
import { NewSheepComponent } from './new-sheep/new-sheep.component';
import { ListSheepComponent } from './list-sheep/list-sheep.component';
import { SettingsComponent } from './settings/settings.component';
import { GenealogyComponent } from './genealogy/genealogy.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SheepInfoComponent,
    NewSheepComponent,
    ListSheepComponent,
    SettingsComponent,
    GenealogyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
