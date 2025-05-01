import Button from "@/shared/components/Button";
import Input from "@/shared/components/Input";
import { z } from "zod";
import { SubmitHandler, useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { EyeOff } from "./ui/EyeOff";

const registerSchema = z.object({
  name: z.string().min(3, { message: "Su nombre es obligatorio" }),
  email: z.string().email({ message: "El email ingresado no es válido" }),
  password: z.string().min(8, { message: "Su contraseña debe tener al menos 8 caracteres" }),
  terms: z.literal(true, {
    errorMap: () => ({ message: "Debes aceptar los términos" }),
  }),
});

export type FormFields = z.infer<typeof registerSchema>;

interface RegistrationFormProps {
  role: string;
}

const RegistrationForm = ({ role }: RegistrationFormProps) => {
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm<FormFields>({
    resolver: zodResolver(registerSchema),
  });

  const onSubmit: SubmitHandler<FormFields> = (formData: FormFields) => {
    console.log("Datos validados --> ", { ...formData, role }); //TODO --> Eliminar el campo terms para enviar al backend
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)} className="flex w-[329px] flex-col gap-4">
      <div>
        <Input type="text" placeholder="Nombre" {...register("name")} />{" "}
        {errors.name && <p className="mt-1 h-6 text-sm text-red-500">{errors.name.message}</p>}
      </div>

      <div>
        <Input type="email" placeholder="e-mail@mail.com" {...register("email")} />{" "}
        {errors.email && <p className="mt-1 h-6 text-sm text-red-500">{errors.email.message}</p>}
      </div>

      <div>
        <div className="relative">
          <Input type="password" placeholder="Contraseña" {...register("password")} />
          <EyeOff className="absolute top-2 right-4 text-gray-500" />
        </div>
        {errors.password && (
          <p className="mt-1 h-6 text-sm text-red-500">{errors.password.message}</p>
        )}
      </div>

      <div className="flex flex-col items-center justify-center">
        <label className="flex items-center justify-center gap-2 text-sm">
          <input type="checkbox" {...register("terms")} className="size-6" />
          <span className="checkbox-label text-[#6E6E6E]">
            Leí y acepto los <u className="hover:cursor-pointer">Términos de uso</u>.
          </span>
        </label>
        {errors.terms && <p className="mt-1 h-6 text-sm text-red-500">{errors.terms.message}</p>}
      </div>

      <Button className="hover:cursor-pointer" type="submit" disabled={isSubmitting}>
        {isSubmitting ? "Registrándose..." : "Registrate"}
      </Button>
    </form>
  );
};

export default RegistrationForm;
