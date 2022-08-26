import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatDialogModule } from '@angular/material/dialog';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatInputModule } from '@angular/material/input';

const materialModules = [
  MatInputModule,
  MatGridListModule,
  MatDialogModule,
  MatInputModule,
  MatGridListModule
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    materialModules
  ],
  exports : [materialModules]
})
export class MaterialModule { }
