import { ImageInserDTO } from '../../../image/dto/imageInsertDTO';

export interface CattleAdInsertDTO {
  title: string
  desc: string
  unitValue: number
  quantity: number
  breed: string
  sex: string
  city: string
  state: string
  cattleAdImages: ImageInserDTO[]
}
