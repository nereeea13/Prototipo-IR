import { formValidators } from "../../../validators/formValidators";
import { registerFormAdmin } from "./registerFormAdmin";

export const registerFormPlayer = [
  ...registerFormAdmin,
  {
    tag: "Age",
    name: "age",
    type: "number",
    defaultValue: "",
    isRequired: true,
    validators: [formValidators.notEmptyValidator, formValidators.validAgeValidator],
    min: 1,
    max: 100,
    // eslint-disable-next-line no-dupe-keys
    defaultValue: 18
  }
];
