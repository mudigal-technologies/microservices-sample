import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './component/root/app.component';
import { DataComponent } from './component/data/data.component';
import { MenuComponent } from './component/menu/menu.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { GatewayService } from './service/gateway/gateway.service';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './component/header/header.component';

export const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'service-one', component: DataComponent},
  {path: 'service-two', component: DataComponent},
  {path: 'service-three', component: DataComponent},
  {path: '**', redirectTo: '/', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    DataComponent,
    MenuComponent,
    HomeComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [GatewayService],
  bootstrap: [AppComponent]
})
export class AppModule { }
