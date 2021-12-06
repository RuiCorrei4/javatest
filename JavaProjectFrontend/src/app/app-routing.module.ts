import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FinancingComponent } from './financing/financing.component';
const routes: Routes = [
  {path:'Financing', component: FinancingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
