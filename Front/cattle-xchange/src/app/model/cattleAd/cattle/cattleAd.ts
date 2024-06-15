import { Image } from '../../image/image';
import { Announcer } from '../../user/dto/Announcer';
import { CattleAdStatus } from '../enum/cattleAdStatus';
import { Sex } from '../enum/sex';

export interface CattleAd {
  id: string;
  title: string;
  desc?: string;
  unitValue: number;
  quantity: number;
  breed: string;
  sex: Sex;
  announcer: Announcer;
  city: string;
  state: string;
  creationDate?: Date;
  status: CattleAdStatus;
  cattleAdImages: Image[];
}
