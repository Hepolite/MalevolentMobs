package com.hepolite.mmob.abilities.passives;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.hepolite.mmob.abilities.PassiveAura;
import com.hepolite.mmob.mobs.MalevolentMob;
import com.hepolite.mmob.settings.Settings;
import com.hepolite.mmob.utility.ParticleEffect;
import com.hepolite.mmob.utility.ParticleEffect.ParticleType;

/**
 * The wither aura will apply the wither effect to all entities within the range
 */
public class PassiveWitherAura extends PassiveAura
{
	private PotionEffect effect = null;

	public PassiveWitherAura(MalevolentMob mob, float scale)
	{
		super(mob, "Wither Aura", scale);
	}

	@Override
	public void loadFromConfig(Settings settings, Settings alternative)
	{
		super.loadFromConfig(settings, alternative);

		float strength = settings.getScaledValue(alternative, "Strength", scale, 1.0f);
		effect = new PotionEffect(PotionEffectType.WITHER, 50, (int) strength - 1);
	}

	@Override
	protected void applyAuraEffect(LivingEntity entity)
	{
		entity.addPotionEffect(effect);
	}

	@Override
	protected void displayAura(Location location, float range)
	{
		ParticleEffect.play(ParticleType.SMOKE_NORMAL, location, 0.08f, (int) (15.0f * range), 0.5f * range);
	}
}
