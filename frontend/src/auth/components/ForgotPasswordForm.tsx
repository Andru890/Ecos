import { zodResolver } from "@hookform/resolvers/zod";
import { SubmitHandler, useForm } from "react-hook-form";
import { z } from "zod";
import Button from "@/shared/components/Button";
import Input from "@/shared/components/Input";
import { EyeOff } from "./ui/EyeOff";

interface RoleSelectorProps {
  onChange: () => void;
}

const LoginSchema = z.object({
  name: z.string().min(3, { message: "Su nombre es obligatorio" }),
  password: z.string().min(8, { message: "Su contraseña debe tener al menos 8 caracteres" }),
});

type LoginFormData = z.infer<typeof LoginSchema>;

const ForgotPasswordForm = ({ onChange }: RoleSelectorProps) => {
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm<LoginFormData>({
    resolver: zodResolver(LoginSchema),
  });

  const handleFormSubmit: SubmitHandler<LoginFormData> = (data: LoginFormData) => {
    console.log("Datos enviados:", data);
  };

  return (
    <form onSubmit={handleSubmit(handleFormSubmit)} className="flex w-[329px] flex-col gap-4">
      <div>
        <Input type="text" {...register("name")} placeholder="Cambiar nombre" />
        {errors.name && (
          <span className="mt-1 h-6 text-sm text-red-500">{errors.name.message}</span>
        )}
      </div>

      <div>
        <div className="relative">
          <Input type="password" placeholder="Cambiar contraseña" {...register("password")} />{" "}
          <EyeOff className="absolute top-2 right-4 text-gray-500" />
        </div>
        {errors.password && (
          <p className="mt-1 h-6 text-sm text-red-500">{errors.password.message}</p>
        )}
      </div>

      <Button type="submit" onClick={onChange} disabled={isSubmitting}>
        {isSubmitting ? "Enviando..." : "Enviar"}
      </Button>
    </form>
  );
};

export default ForgotPasswordForm;
